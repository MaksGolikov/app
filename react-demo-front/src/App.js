import React, { useEffect, useState } from "react";

function App() {
  const [students, setStudents] = useState([]);
  const [errors, setErrors] = useState({});

  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [email, setEmail] = useState("");

  const [search, setSearch] = useState("");

  //  отримати всіх студентів
  const fetchStudents = async () => {
    const res = await fetch("http://localhost:8080/api/students");
    const data = await res.json();
    setStudents(data);
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  //  додати студента
  const addStudent = async (e) => {
    e.preventDefault();

    const res = await fetch("http://localhost:8080/api/students", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name, age, email }),
    });

    if (!res.ok) {
      const data = await res.json();
      setErrors(data);
      return;
    }

    setErrors({}); // очистити помилки

    setName("");
    setAge("");
    setEmail("");

    fetchStudents();
  };

  //  пошук студентів
  const searchStudents = async () => {
    if (!search) {
      fetchStudents();
      return;
    }

    const res = await fetch(
        `http://localhost:8080/api/students/search?name=${search}`
    );
    const data = await res.json();
    setStudents(data);
  };

  return (
      <div style={{ padding: "20px" }}>
        <h1>Students</h1>

        {/*  ПОШУК */}
        <div style={{ marginBottom: "20px" }}>
          <input
              placeholder="Search by name..."
              value={search}
              onChange={(e) => setSearch(e.target.value)}
          />
          <button onClick={searchStudents}>Search</button>
          <button onClick={fetchStudents}>Reset</button>
        </div>

        {/*  ДОДАВАННЯ */}
        <form onSubmit={addStudent}>
          <div>
            <input
                placeholder="Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
            {errors.name && <p style={{color: "red"}}>{errors.name}</p>}
          </div>

          <div>
            <input
                type={'number'} /*  для валідації саме на frontend частині */
                placeholder="Age"
                value={age}
                onChange={(e) => setAge(e.target.value)}
            />
            {errors.age && <p style={{ color: "red" }}>{errors.age}</p>}
          </div>

          <div>
            <input
                type={'email'} /*  для валідації саме на frontend частині */
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            {errors.email && <p style={{ color: "red" }}>{errors.email}</p>}
          </div>

          <button type="submit">Add</button>
        </form>

        {/*  СПИСОК */}
        <h2>List</h2>
        <ul>
          {students.map((s, index) => (
              <li key={index}>
                {s.name} ({s.age}) - {s.email}
              </li>
          ))}
        </ul>
      </div>
  );
}

export default App;