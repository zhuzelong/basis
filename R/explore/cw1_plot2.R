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
png('plot2.png', width=480, height=480, units='px')

# Plot the line chart
plot(data$Time, data$Global_active_power, type='l',
     xlab=NA, ylab='Global Active Power (kilowatts)')
dev.off()