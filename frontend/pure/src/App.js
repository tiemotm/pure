import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import List from './components/List';
import StudentForm from './components/StudentForm'

function App() {
    return (
      <Router>
        <Routes>
          <Route path='/students/' element={<List/>}>
            <Route path=':matrikelnummer' element={<List/>}/>
          </Route>
          <Route path='/newStudent' element={<StudentForm/>}/>
        </Routes>
      </Router>
    )
}

export default App