import pandas as pd
from pymongo import MongoClient

# load csv
csv_file = "span_eng_lang_data.csv"
data = pd.read_csv(csv_file, sep='\t')  # Assuming tab-separated values

# Convert DataFrame to a list of dictionaries in the desired format
documents = [{"_id": row['Number'], "word": row['Spanish'], "def": [row['inEnglish']]} for _, row in data.iterrows()]

# Connect to MongoDB Atlas
client = MongoClient("MONGODBURI")
db = client["spang_prod"]
collection = db["spang_eng"]

# Insert documents into MongoDB
try:
    collection.insert_many(documents, ordered=False)
    print("Data inserted successfully!")
except Exception as e:
    print(f"An error occurred: {e}")
