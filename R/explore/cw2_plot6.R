# Exploratory Data Analysis Course Project 2
# Question 5:
# -------------
# -------------

# Use the package "data.table" and "ggplot2"
library('data.table')
library('ggplot2')

# Read data from source file
setwd('~/Documents/code/course/R/explore/')
nei = readRDS(file='../data/exdata-data-NEI_data/summarySCC_PM25.rds')
scc = readRDS(file='../data/exdata-data-NEI_data/Source_Classification_Code.rds')

# Convert the two data frames to data tables, by reference
setDT(nei)
setDT(scc)

# Set keys for NEI and SCC for further join operation
setkey(nei, SCC)
setkey(scc, SCC)

# Filter rows of Balitmore City and LA
subnei = nei[fips=='24510' | fips=='06037']
# Join the subnei with SCC to find emissions from motor vehicle
data = scc[subnei]
# Refer to the discussion forum, use 'Onroad' to filer motor vehicles
sub = data[grep('Onroad', Data.Category)]
# Aggregate the emissions in sub data by year
emit = sub[, sum(Emissions), by=list(fips, year)]
setnames(emit, c('fips', 'year', 'emissions'))

# Plot total emissions against years and save to a png file
# Use ggplot2 to accomplish the task
png('../result/explore/cw2_plot6.png', width=480, height=480)
# The emissions in Baltimore City and LA have large discrepancy, so use log()
p = ggplot(data=emit, aes(year, log(emissions), colour=fips))
p = p + geom_point() + geom_line()
p = p + labs(x='year', y='emissions (unit: tons)',
             title='Emissions of PM2.5 from mobile vehicles')
# Change the legend
g = p + scale_colour_manual('City\n', 
                            labels=c('Los Angeles', 'Baltimore City'),
                            values=c('red', 'blue'))
print(g)
dev.off()