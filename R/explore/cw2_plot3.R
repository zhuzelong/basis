# Exploratory Data Analysis Course Project 2
# Question 3:
# -------------
# Of the four types of sources indicated by the type
# (point, nonpoint, onroad, nonroad) variable, which of these four sources
# have seen decreases in emissions from 1999–2008 for Baltimore City?
# Which have seen increases in emissions from 1999–2008?
# Use the ggplot2 plotting system to make a plot answer this question.
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

# Filter rows of Balitmore City
subnei = nei[fips=='24510']
# Compute total emissions in Baltimore City in each year and each type of source
emit = subnei[, sum(Emissions), by=list(type, year)]
setnames(emit, c('type', 'year', 'emissions'))

# Plot total emissions against years and save to a png file
# Use ggplot2 to accomplish the task
png('../result/explore/cw2_plot3.png', width=480, height=480)
p = ggplot(data=emit, aes(year, emissions, colour=type))
p = p + geom_point() + geom_line()
p = p + labs(x='year', y='emissions (unit: tons)',
             title='Emissions of PM2.5 in Baltimore City')
print(p)
dev.off()