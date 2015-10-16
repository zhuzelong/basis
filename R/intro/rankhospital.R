rankhospital = function(state, outcome, num='best')
{
    # Read outcome data
    outcomes = read.csv('data/progassignment3-data/outcome-of-care-measures.csv',
                        colClasses='character')
    
    # Check that state and outcome are valid
    outcome.list = c('heart attack', 'heart failure', 'pneumonia')
    if(!state %in% outcomes$State)
        stop('invalid state')
    if(!outcome %in% outcome.list)
        stop('invalid outcome')
    
    # Return hospital name in that state with the given
    # rank 30-day death rate
    data = outcomes[outcomes$State == state, ]
    outcome = paste('Hospital.30.Day.Death..Mortality..Rates.from.', 
                    simpleCap(outcome), sep='')
    ordered.indices= order(as.numeric(data[[outcome]]),
                         data$Hospital.Name, na.last=NA)
    
    if(toupper(num) == 'BEST')
        return(data$Hospital.Name[ordered.indices[1]])
    else if(toupper(num) == 'WORST')
        return(data$Hospital.Name[tail(ordered.indices, 1)])
    else if(num > max(ordered.indices))
        return(NA)
    else
        return(data$Hospital.Name[ordered.indices[num]])
}


simpleCap = function(x)
{
    s = strsplit(x, " ")[[1]]
    paste(toupper(substring(s, 1, 1)), substring(s, 2), sep='', collapse='.')
}