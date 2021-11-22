import React, {useState, useEffect} from "react"
import axios from "axios"

function List(props) {
    const [students, setStudents] = useState([])

    const fetchStudents = () => {
        axios.get("/api/students/")
            .then(res => res.data)
            .then(data => setStudents(data))
    }

    useEffect(() => {
        fetchStudents()
        console.log(setStudents)
    }, [])

    
    return (
        <table>
            <tr>
                <th>Name</th>
                <th>Matrikelnummer</th>
                <th>Unikennung</th>
                <th>Unikennung</th>
                <th>Githubhandle</th>
            </tr>
            {students.map(s => (
                <tr key={s.matrikelnummer}>
                    <td>{s.name}</td>
                    <td>{s.matrikelnummer}</td>
                    <td>{s.unikennung}</td>
                    <td>{s.githubhandle}</td>
                </tr>
            ))}
        </table>
    )
}

export default List