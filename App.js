import React, { useState } from "react";
import './App.css';
import { Router,Routes,Route} from "react-router-dom";
import { Login } from "./Login";
import { Signup } from "./Signup";
import "../node_modules/bootstrap/dist/css/bootstrap-grid.min.css";
import Home from "./Home";
import Viewproduct from "./Viewproduct";
import Addproduct from "./Addproduct";
import Editproduct from "./Editproduct";

function App() {
  

  return (
    <div className="App">
      <Router>
        <Routes>
        <Route path="/Login/Signup" element={<Signup/>} /> 
          <Route path="/" element={<Login/>} />    
          <Route exact path="/main" element={<Home/>} />
        <Route exact path="/Addproduct" element={<Addproduct/>} />
        <Route exact path="/Editproduct/:ccode" element={<Editproduct/>} />
        <Route exact path="/Viewproduct/:ccode" element={<Viewproduct/>} /> 
        </Routes>
      </Router>
    </div>
  );
}

export default App;