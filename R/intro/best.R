best = function(state, outcome)
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
    
    # Return hospital name in that state with lowest
    # 30-day deaath rate
    data = outcomes[outcomes$State == state, ]
    outcome = paste('Hospital.30.Day.Death..Mortality..Rates.from.', 
                    simpleCap(outcome), sep='')
    
    min.mortal = min(data[[outcome]], na.rm=T)
    names = data[data[[outcome]] == min.mortal, 'Hospital.Name']
    
    return(min(names))
}


simpleCap = function(x)
{
    s = strsplit(x, " ")[[1]]
    paste(toupper(substring(s, 1, 1)), substring(s, 2), sep='', collapse='.')
}
