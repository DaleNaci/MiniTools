import statistics as stats

numString = input("Data: ")

# values = map(float, numString.split(", "))
split = numString.split(", ")
values = [float(s) for s in split]

print("Mean:", stats.mean(values))
print("Stdev:", stats.stdev(values))
