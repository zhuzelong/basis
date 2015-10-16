"""
Test a call alarm using Poisson Distribution.
"""

import scipy
from scipy.stats import poisson


def poisson_pr(alarm_limit, num_calls, current_time):
    """
    Calculate the probability of alarm using Poisson distribution.
    """

    hour_rate = float(alarm_limit) / 24.0
    remain_hours = 24 - int(current_time)
    success_rate = float(remain_hours * hour_rate)
    # Normal condition
    if alarm_limit > num_calls and remain_hours != 0:
        # Poisson variable is remaining num of calls to raise the alarm.
        poisson_var = alarm_limit - num_calls
        remain_pr = float(scipy.stats.poisson.pmf(
                        poisson_var, success_rate) * 100)
        reach_pr = float(1 - scipy.stats.poisson.cdf(
                            poisson_var-1, success_rate)) * 100
    # No danger
    elif alarm_limit > num_calls and remain_hours == 0:
        poisson_var = alarm_limit - num_calls
        remain_pr = 0
        reach_pr = 0
    # Raise alarm!
    else:
        poisson_var = 0
        reach_pr = 100
    return (poisson_var, hour_rate, remain_hours, reach_pr, success_rate)


if __name__ == '__main__':
    alarm_limit = 8
    num_calls = 2
    current_time = 2

    poisson_var, hour_rate, remain_hours, reach_pr, success_rate = \
        poisson_pr(alarm_limit, num_calls, current_time)
    print 'Poisson variable x is %d' % (poisson_var)
    print 'Rate of success in hour %f' % (hour_rate)
    print 'Rate of success is %f' % (success_rate)
    print 'Remaining hours: %f' % (remain_hours)
    print 'Probability of raising alarm is %f' % (reach_pr)
