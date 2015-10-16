# Exploratory Data Analysis Course Project 2
# Question 2:
# -------------
# Have total emissions from PM2.5 decreased in the Baltimore City, Maryland
# (fips == "24510") from 1999 to 2008? Use the base plotting system to make
# a plot answering this question.
# -------------

# Use the package "data.table"
library('data.table')

# Read data from source file
setwd('~/Documents/code/course/R/explore/')
nei = readRDS(file='../data/exdata-data-NEI_data/summarySCC_PM25.rds')
scc = readRDS(file='../data/exdata-data-NEI_data/Source_Classification_Code.rds')

# Convert the two data frames to data tables, by reference
setDT(nei)
setDT(scc)

# Filter rows of Balitmore City
subnei = nei[fips=='24510']
# Compute total emissions in Baltimore City in each year
total.emit = subnei[, sum(Emissions), by=year]
setnames(total.emit, c('year', 'emissions'))

# Plot total emissions against years and save to a png file
png('../result/explore/cw2_plot2.png', width=480, height=480)
plot(total.emit$year, total.emit$emissions, type='b', xlab='Year',
     ylab='Total emissions (unit: tons)',
     main='Total Emissions of PM2.5 in Baltimore City')
dev.off()