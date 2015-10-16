# Exploratory Data Analysis Course Project 2
# Question 1:
# -------------
# Have total emissions from PM2.5 decreased in the United States 
# from 1999 to 2008? Using the base plotting system, make a plot showing
# the total PM2.5 emission from all sources for each of the years 
# 1999, 2002, 2005, and 2008.
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

# Compute total emissions of each year
total.emit = nei[, sum(Emissions), by=year]
setnames(total.emit, c('year', 'emissions'))

# Plot total emissions against years and save to a png file
png('../result/explore/cw2_plot1.png', width=480, height=480)
plot(total.emit$year, total.emit$emissions, type='b', xlab='Year',
     ylab='Total emissions (unit: tons)',
     main='Total Emissions of PM2.5 in USA')
dev.off()
 

