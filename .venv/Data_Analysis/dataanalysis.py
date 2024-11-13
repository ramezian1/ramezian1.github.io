import pandas as pd
import matplotlib.pyplot as plt

# Load the dataset from 'data.csv'
data = pd.read_csv('.venv\Data_Analysis\data.csv')

# Check the data types and convert 'Age' to numeric
data['Age'] = pd.to_numeric(data['Age'], errors='coerce')

# Drop rows with NaN values in the 'Age' column
data.dropna(subset=['Age'], inplace=True)

# Calculate the average age
age_mean = data['Age'].mean()

# Print the average age to the console
print(f"Average Age: {age_mean}")

# Create a bar chart to display the average age
plt.bar('Average Age', age_mean)
plt.xlabel('Metrics')
plt.ylabel('Age')
plt.title('Average Age of Users')

# Display the plot
plt.show()
