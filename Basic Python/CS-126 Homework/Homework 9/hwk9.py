import sys

csv_year = sys.argv[2]

with open('summary.txt', 'w') as csv_write, open(sys.argv[1], 'r') as csv_file:
    line_counter = 0
    sorted_lines = []

    for line in csv_file.readlines():

        if line_counter == 0:
            headers = line.strip().split(',')
            populations = headers.index('Projected Populations')
            years = headers.index("Year")
            states = headers.index("State")
            line_counter += 1
            continue

        else:
            line = line.split(',')
            line = [col.strip() for col in line]

            if str(line[years]).strip() == csv_year:
                sorted_lines.append(line)

    sorted_lines.sort(key = lambda x: x[states].lower())
    
    for line in sorted_lines:
        csv_write.write(line[states].title().replace('Of ', 'of ') + ': ' + line[populations] + '\n')
