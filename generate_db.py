import requests

url = "https://moviesdatabase.p.rapidapi.com/titles/"

# DoNt PuBlISh aPI KeYs
headers = {
	"X-RapidAPI-Key": "3fc8cda7e4mshed5e65caefa91f1p1214abjsnc6d9c95234c5",
	"X-RapidAPI-Host": "moviesdatabase.p.rapidapi.com"
}

response = requests.get(url, headers=headers)

print(response.json())