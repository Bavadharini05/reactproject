import React, { } from "react";
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
export default function Home() {

  const [product, setproduct] = useState([]);

  useEffect(() => {
    loadproduct();
  }, []);

  const loadproduct = async () => {
    const result = await axios.get('localhost:8080/sortdes/cname');
    setproduct(result.data);
  };

  const deleteproduct = async (ccode) => {

    await axios.delete(`localhost:8080/deleteid/123`)
    loadproduct();
  };

  return (
    <div className="container">
      <nav className="navbar my-4 navbar-expand-lg navbar-dark bg-secondary">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/main">
            All  Details
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <Link className="btn btn-outline-light" to="/Addproduct">
            ADD DETAILS
          </Link>
        </div>
      </nav>

      <div className="py-4">
        <table className="table border dark shadow">
          <thead>
            <tr>
              <th scope="col">product id</th>
              <th scope="col">Product Name</th>
              <th scope="col">Product Brand</th>
              <th scope="col">Product Rate</th>
              <th scope="col">Product Used</th>

            </tr>
          </thead>
          <tbody>
            {product.map((product, index) => (
              <tr key={index}>
                <th scope="row">{index + 1}</th>
                <td>{product.cname}</td>
                <td>{product.cbrand}</td>
                <td>{product.crate}</td>
                <td>{product.cused}</td>
                <td>
                  <Link className="btn btn-outline-success mx-2" to={`/Viewproduct/${product.ccode}`}>
                    VIEW 
                  </Link>
                  {console.log(product.ccode)}
                  <Link className="btn btn-outline-primary mx-2" to={`/Editproduct/${product.ccode}`}>
                    EDIT
                  </Link>
                  <button
                    className="btn btn-outline-danger mx-2"
                    onClick={() => deleteproduct(product.ccode)}
                  >
                    DELETE
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}



