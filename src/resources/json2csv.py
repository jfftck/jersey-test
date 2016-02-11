# Python 2.7
import json
import csv

# Read the JSON file and create a Python object
json_data = json.load(open('./products.json'))

# Create a CVS file from the Python object
with open('./products.csv', 'wb') as csv_file:
    writer = csv.DictWriter(csv_file, [x for x in json_data['products'][0].keys()])
    writer.writeheader()
    for item in json_data['products']:
        writer.writerow(item)