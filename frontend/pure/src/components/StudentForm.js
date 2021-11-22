import React, {useState, useEffect} from "react"
import axios from "axios"

function StudentForm() {
    const initialState = {
        name: "",
        matrikelnummer: "",
        unikennung: "",
        githubhandle: ""
    }

    const [student, setStudent] = useState(initialState)
    
    const submit = (event) => {
        event.preventDefault()
        console.log(JSON.stringify(student))
        axios.post("/api/students", JSON.stringify(student), {
            headers: {
                "Content-Type": "application/json"
            }
        })
        resetStudent()
    }

    const resetStudent = () => {
        setStudent(initialState)
    }

    return (
        <form onSubmit={submit}>
            <div className="mb-3">
                <label className="mb-2" htmlFor="name">Name</label>
                <input
                    className="form-control"
                    id="name" name="name"
                    placeholder="Erika Mustermann"
                    value={student.name}
                    onChange={event => setStudent({...student, name: event.target.value})}
                />
            </div>
            <div className="mb-3">
                <label className="mb-2" htmlFor="matrikelnummer">Matrikelnummer</label>
                <input
                    className="form-control"
                    id="matrikelnummer" name="matrikelnummer"
                    placeholder="1234567"
                    type="number"
                    value={student.matrikelnummer}
                    onChange={event => setStudent({...student, matrikelnummer: parseInt(event.target.value)})}
                />
            </div>
            <div className="mb-3">
                <label className="mb-2" htmlFor="unikennung">Universitätskennung</label>
                <input
                    className="form-control"
                    id="unikennung" name="unikennung"
                    placeholder="ermus122"
                    value={student.unikennung}
                    onChange={event => setStudent({...student, unikennung: event.target.value})}
                />
            </div>
            <div className="mb-3">
                <label className="mb-2" htmlFor="githubhandle">GitHub Benutzername</label>
                <input
                    className="form-control"
                    id="githubhandle" name="githubhandle"
                    placeholder="n20"
                    value={student.githubhandle}
                    onChange={event => setStudent({...student, githubhandle: event.target.value})}
                />
            </div>
            <div className="mb-3">
                <button className="btn btn-primary" type="submit">Submit</button>
            </div>
        </form>
    )
}

export default StudentForm