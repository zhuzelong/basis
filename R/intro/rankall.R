rankall = function(outcome, num='best')
{
    # Read outcome data
    outcomes = read.csv('data/progassignment3-data/outcome-of-care-measures.csv',
                        colClasses='character')
    
    # Check that state and outcome are valid
    outcome.list = c('heart attack', 'heart failure', 'pneumonia')
    if(!outcome %in% outcome.list)
        stop('invalid outcome')
    
    # For each state, find the hospital of the given rank
    outcome = paste('Hospital.30.Day.Death..Mortality..Rates.from.', 
                    simpleCap(outcome), sep='')
    #ordered.list = tapply(as.numeric(outcomes[[outcome]]), states,
    #                      order, split(outcomes$Hospital.Name, states),
    #                      na.last=NA)
    order.data= outcomes[order(outcomes$State, as.numeric(outcomes[[outcome]]),
                         outcomes$Hospital.Name, na.last=NA), ]
    
    names = c()
    states = levels(factor(outcomes$State))
    for(state in states)
    {
        data = order.data[order.data$State == state, ]
        if(toupper(num) == 'BEST')
            names = c(names, data[1, 'Hospital.Name'])
        else if(toupper(num) == 'WORST')
            names = c(names, data[nrow(data), 'Hospital.Name'])
        else if(num > nrow(data))
            names = c(names, NA)
        else
            names = c(names, data[num, 'Hospital.Name'])
    }

    # Return a data frame with hospital name and
    # the abbreviated state name
    all.rank = data.frame(hospital=names, state=states)
}


simpleCap = function(x)
{
    s = strsplit(x, " ")[[1]]
    paste(toupper(substring(s, 1, 1)), substring(s, 2), sep='', collapse='.')
}