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

# Create a png device and set its size
png('plot1.png', width=480, height=480, units='px')
# Plot the histogram
hist(data$Global_active_power, xlab='Global Active Power (kilowatts)',
     ylab='Frequency', main='Global Active Power', col='red')
dev.off()
