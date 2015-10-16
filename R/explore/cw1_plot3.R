library('data.table')
# Read data from the text file
# The target dates ranges from 66638 to 69517 in the text file
data = fread(input='./data/household_power_consumption.txt', sep=';',
             nrows=2880, header=F, na.strings='?', skip=66637)
# Read the header from the text file
head = names(fread(input='./data/household_power_consumption.txt', sep=';',
                   nrow=1))
# Add header to the data.table
setnames(data, head)

# Convert the column "Time" to DateTime
# Use as.POSIXct instead of strptime, the latter cannot deal with column
data$Time = paste(data$Date, data$Time)
data$Time = as.POSIXct(data$Time, format='%d/%m/%Y %T')

# Create a png device and set its size
png('plot3.png', width=480, height=480, units='px')

# Plot the line chart
lim = range(data$Sub_metering_1, data$Sub_metering_2, data$Sub_metering_3)
# Plot Sub_metering_1
plot(data$Time, data$Sub_metering_1, type='l', col='black', ylim=lim,
     xlab=NA, ylab='Energy sub metering')
# Hold the plot
par(new=T)
# Plot Sub_metering_2
plot(data$Time, data$Sub_metering_2, type='l', col='red', ylim=lim, axes=F,
     xlab=NA, ylab=NA)
par(new=T)
# Plot Sub_metering_3
plot(data$Time, data$Sub_metering_3, type='l', col='blue', ylim=lim, axes=F,
     xlab=NA, ylab=NA)
# Plot legend
legend(x='topright',
       legend=c('Sub_metering_1', 'Sub_metering_2', 'Sub_metering_3'),
       col=c('black', 'red', 'blue'), lty=1
)

dev.off()