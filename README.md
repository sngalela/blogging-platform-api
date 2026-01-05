
# 📝 Blogging Platform API

A simple **RESTful API** built with **Spring Boot** that provides basic **CRUD operations** for a personal blogging platform.
This project demonstrates REST principles, HTTP methods, validation, error handling, and database integration using Java and Spring Boot.

---

## 🚀 Features

- Create a new blog post
- Update an existing blog post
- Delete a blog post
- Retrieve a single blog post
- Retrieve all blog posts
- Filter blog posts using a search term (title, content, or category)
- Request validation and proper HTTP status codes

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 🧱 Blog Post Model

```json
{
  "id": 1,
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2021-09-01T12:00:00Z",
  "updatedAt": "2021-09-01T12:00:00Z"
}
```

---

## 📌 API Endpoints

### Create Blog Post
**POST** `/posts`

```json
{
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

### Update Blog Post
**PUT** `/posts/{id}`

```json
{
  "title": "My Updated Blog Post",
  "content": "This is the content of my updated blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

### Delete Blog Post
**DELETE** `/posts/{id}`

### Get Single Blog Post
**GET** `/posts/{id}`

### Get All Blog Posts
**GET** `/posts`

### Filter Blog Posts
**GET** `/posts?term=tech`

---

## ⚠️ Error Handling

Centralized exception handling ensures consistent error responses.

---

## ▶️ Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

API available at:
```
http://localhost:8080
```

---
