from flask import Flask
app= Flask(__name__)

@app.route("/")
def Hello():
    return "Hello, Docker!"

app.run(host="0.0.0.0", port=5000)
