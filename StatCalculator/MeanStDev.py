import statistics as stats


values = []

with open("data.txt") as in_f:
    for line in in_f.readlines():
        for point in line.split():
            values.append(float(point))


print("Mean:", stats.mean(values))
print("Stdev:", stats.stdev(values))
