import sys

csv_year = sys.argv[2]

with open('summary.txt', 'w') as csv_write, open(sys.argv[1], 'r') as csv_file:
    line_counter = 0    
    for line in csv_file.readlines():
        if line_counter == 0:
            headers = line.strip().split(',')
            populations = headers.index('Projected Populations')
            line_counter += 1
            continue
        else:
            line = line.split(',')
            if str(line[2]).strip() == csv_year:
                csv_write.write(line[0].title() + ': ' + line[populations])
                


