# Exploratory Data Analysis Course Project 2
# Question 4:
# -------------
# Across the United States, how have emissions from coal combustion-related
# sources changed from 1999–2008?
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

# Set keys for NEI and SCC, to enable join
setkey(nei, SCC)
setkey(scc, SCC)

# Join NEI and SCC, on the column "SCC"
data = scc[nei]

# Subset the data where "EI.Sector" involves "Coal"
sub = data[grep('Coal$', EI.Sector)]

# Aggregate the emissions by year
emit = sub[, sum(Emissions), by=year]
setnames(emit, c('year', 'emissions'))

# Use ggplot2 to accomplish the task
png('../result/explore/cw2_plot4.png', width=480, height=480)
p = ggplot(data=emit, aes(year, emissions))
p = p + geom_point() + geom_line()
p = p + labs(x='year', y='emissions (unit: tons)',
             title='Emissions of PM2.5 from coal combustion in USA')
print(p)
dev.off()