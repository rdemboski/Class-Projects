with open("data.csv", 'r') as csv_open:
    with open("summary.txt", 'w') as csv_write:

        def write_summary():
            line_counter = 0    
            for line in csv_open.readlines():
                if line_counter == 0:
                    line_counter += 1
                    continue
                else:
                    line = line.split(',')
                    if line[2] in ['2025', 2025]:
                        csv_write.write(line[0] + ': ' + line[4])

        write_summary()
