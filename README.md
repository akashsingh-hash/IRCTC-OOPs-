🚆 Book My Train – IRCTC Console Application

A clean, modular, OOP-based Java console project simulating IRCTC train booking.

<p align="center"> <img src="https://img.shields.io/badge/Java-17+-red?style=for-the-badge"/> <img src="https://img.shields.io/badge/OOP-Encapsulation%20%7C%20Abstraction%20%7C%20Modularity-blue?style=for-the-badge"/> <img src="https://img.shields.io/badge/Build-JavaC%20%2F%20Console-green?style=for-the-badge"/> <img src="https://img.shields.io/badge/Status-Active-brightgreen?style=for-the-badge"/> </p>
✨ Overview

Book My Train is a fully functional IRCTC-style train booking console application built in Java using Object-Oriented Programming principles.
It demonstrates:
✔ OOP

✔ Collections (ArrayList, HashMap)

✔ Console UI

✔ Modular Code Architecture

✔ In-memory Data Storage

Perfect for Java beginners practicing DSA + OOP + project structuring.
📌 Features
👤 User Management

Register new user accounts
Login / Logout

User session management
🚆 Train Management
List all available trains
Search trains by source & destination
View seat availability

🎟 Ticket Operations
Book ticket
View all tickets booked by a user
Cancel ticket + auto seat restoration
Auto ticket-ID generation

🧱 Project Architecture
📦 Book-My-Train
│
├── IRCTCAPP.java           # Main entry console UI (menu navigation)
├── User.java               # User model
├── Train.java              # Train model + seat logic
├── Ticket.java             # Ticket model (user + train + seats)
│
├── UserService.java        # Registration, login, session
├── BookingService.java     # Search, booking, cancellation
│
└── README.md               # Documentation

🧩 Tech Stack
Language
Java 8+ / Java 17 recommended
Runtime / Environment
Console Application (CMD / PowerShell / Terminal)
No external frameworks
Data Storage

In-memory collections:
ArrayList
HashMap
AtomicInteger (for auto ticket IDs)

🧪 OOP Concepts Used
✔ Encapsulation
All models (User, Train, Ticket) have private fields with getters/setters.
✔ Abstraction
UserService and BookingService expose simple methods like:
registerUser()
loginUser()
searchTrain()
bookTicket()


✔ Modularity
Every class follows Single Responsibility Principle.


==============================================
      WELCOME TO BOOK MY TRAIN (IRCTC CLI)
==============================================
1. Register
2. Login
3. Exit

🛠 How to Run
1. Clone the Repository
git clone [https://github.com/akashsingh-hash/IRCTC-OOPs-.git](https://github.com/akashsingh-hash/IRCTC-OOPs-)
cd book-my-train
2. Compile
javac IRCTCAPP.java
3. Run
java IRCTCAPP

🔍 Key Classes (Explained)

🧑‍💻 User
username
password
full name
contact

🚆 Train
trainId
name
source
destination
totalSeats
availableSeats

🎟 Ticket
ticketId
user
train
seats booked
booking timestamp

🔐 UserService
register user
login
logout
get current user

📦 BookingService
list all trains
search trains
book ticket
cancel ticket
list user tickets

✔️ Future Enhancements (Optional)
File-based storage (saving users, trains, tickets)
Train sorting / filtering

🙌 Contributing

Pull requests are welcome!
For major changes, please open an issue first.

📝 License

This project is free to use for learning & academic purposes.
