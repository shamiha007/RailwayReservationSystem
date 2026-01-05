# 🚆 Railway Reservation System

A web-based **Railway Reservation System** developed using **Java Servlets, JSP, JDBC, and MySQL**.  
This application allows users to search trains, book tickets, cancel bookings, and enables admins to manage trains, schedules, and bookings efficiently.

---

## 🧩 Project Overview

The Railway Reservation System is designed to automate the traditional railway ticket booking process.  
It provides separate modules for **Users** and **Admins**, ensuring secure access and smooth management of railway operations.

---

## 🎯 Objectives

- To provide an online platform for railway ticket booking
- To reduce manual work and paperwork
- To ensure secure user authentication
- To enable admins to manage trains, schedules, and bookings
- To maintain booking and cancellation history

---

## 👥 User Roles

### 🔹 User
- Register & Login
- Search trains by source, destination, and date
- View available seats
- Book tickets
- Cancel booked tickets
- View booking history
- Logout securely

### 🔹 Admin
- Admin login
- Add new trains
- Add train schedules
- View all users
- View all bookings
- Cancel user bookings
- Delete train schedules
- Logout securely

---

## ⚙️ Functional Modules

### 1️⃣ Authentication Module
- User registration
- User login & logout
- Admin login

### 2️⃣ Train Management Module (Admin)
- Add train details
- View train list
- Add journey schedules
- Delete schedules

### 3️⃣ Booking Module
- Search trains
- Seat availability check
- Ticket booking
- Booking cancellation
- Auto seat update after booking/cancellation

### 4️⃣ Admin Booking Control
- View all bookings
- Cancel any user booking

---

## 🛠️ Technologies Used

| Layer | Technology |
|-----|-----------|
| Frontend | HTML, CSS, JSP |
| Backend | Java Servlets |
| Database | MySQL |
| Connectivity | JDBC |
| Server | Apache Tomcat |
| IDE | Eclipse |
| Version Control | Git & GitHub |

---

## 🗂️ Project Structure

RailwayReservationSystem
│
├── src/main/java
│ ├── com.railway.servlet
│ ├── com.railway.dao
│ ├── com.railway.model
│ └── com.railway.util
│
├── src/main/webapp
│ ├── adminHome.jsp
│ ├── login.jsp
│ ├── register.jsp
│ ├── search.jsp
│ ├── bookTicket.jsp
│ ├── myBookings.jsp
│ ├── confirmCancel.jsp
│ ├── confirmDeleteSchedule.jsp
│ └── css/style.css
│
├── WEB-INF
│ └── web.xml
│
└── README.md
---

## 🗄️ Database Details

### Database Name
```sql
railway_reservation

:Main Tables

1.users

2.admin

3.trains

4.train_schedule

5.bookings

▶️ How to Run the Project

1.Install JDK 8 or above

2.Install Apache Tomcat 9

3.Install MySQL Server

4.Import the project into Eclipse

5.Configure database connection in DBUtil.java

6.Create database and tables using SQL script

7.Start Tomcat server

8.Open browser and run:

http://localhost:8080/RailwayReservationSystem/

🔒 Security Features

1.Session-based authentication

2.Role-based access (User / Admin)

3.Proper logout handling

4.Server-side validation

🚀 Future Enhancements

1.Online payment integration

2.Seat selection

3.Email / SMS notifications

4.Responsive UI

👩‍💻 Developed By

Shamiha Sherin
B.Tech Information Technology



