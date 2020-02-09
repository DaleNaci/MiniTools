import statistics as stats
import numpy as np

values = []

with open("data.txt") as in_f:
    for line in in_f.readlines():
        for point in line.split():
            values.append(float(point))

median = stats.median(values)
q1 = np.quantile(values, .25)
q3 = np.quantile(values, .75)
min = min(values)
max = max(values)
bot_outliers = len([i for i in values if i <= ((q1-q3) * 1.5 + q1)])
top_outliers = len([i for i in values if i >= ((q3-q1) * 1.5 + q3)])

print("Median:", median)
print("Q1:", q1)
print("Q3:", q3)
print("Min:", min)
print("Max:", max)
print("Bottom Outliers:", bot_outliers)
print("Top Outliers:", top_outliers)
