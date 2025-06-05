# Use an official Python image
FROM python:3.9-slim

# Set working directory
WORKDIR /app

# Copy dependencies and app
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt
COPY . .

# Run app
CMD ["python", "app.py"]

