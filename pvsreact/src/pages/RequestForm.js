import { Link } from "react-router-dom"
import styles from "../CSS/styleRequest.module.css"
import { useState } from "react"
import { useNavigate } from "react-router-dom"
import { useEffect } from "react";
import axios from "axios";

// import React, { useState } from 'react';
// import styles from './ProductUploadForm.module.css';



const ProductUploadForm = () => {
  const [selectedValue, setSelectedValue] = useState('');
  const [selectedValue2, setSelectedValue2] = useState('');
  const [productName, setproductName] = useState('');
  const [Price, setPrice] = useState('');
  const [brandName, setBrandName] = useState('');
  const [Description, setDescription] = useState('');
  const [image, setImage] = useState('');
  const [responseText, setResponseText] = useState(null);
const handleSelectChange = (e) => {
    setSelectedValue(e.target.value);
    console.log(selectedValue);
  }

  const handleSelectChange2 = (e) => {
      setSelectedValue2(e.target.value);
      console.log(selectedValue2);
    }
    const handleProductName = (e) => {
      setproductName(e.target.value);
      console.log(productName);
    }
    const handleDescription = (e) => {
      setDescription(e.target.value);
      console.log(Description);
    }
    const handlePrice = (e) => {
      setPrice(e.target.value);
      console.log(Price);
    }
    const handleBrandName = (e) => {
      setBrandName(e.target.value);
      console.log(brandName);
    }
  

  const handleFileChange = (e) => {
    const file = e.target.files[0];
    console.log(file.name);
    setImage(file.name);
  }
  const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmRvMkBnbWFpbC5jb20iLCJpYXQiOjE3MDIzNzM4ODQsImV4cCI6MTcwMjQ2MDI4NH0.rZzFcP6Yk3IBIdG4HaZrKZmHhSNIc9rjoRBLUiuqmj8' 
  const handleSubmit = async (e) => { 
    e.preventDefault();
    const response = await fetch('http://localhost:8080/api/addNewProduct', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`,
        },
        body: JSON.stringify({
          name : productName,
          brandName : brandName,
          description : Description,
          price : Price ,
          targetAnimal : selectedValue,
          categoryName: selectedValue2,
          userEmail :'abdo@gmail.com' ,
          photo : image,
          
        }),
    })
         
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    // Assuming the server returns a string
    const textResponse = await response.text();
    console.log(textResponse);
    if(textResponse == "Added to database..."){
      window.alert("Uploading success and waiting For admin acceptance");
    }
         
          setBrandName("");
          setDescription("");
          setImage(null);
          setPrice("");
          setproductName("");
          setSelectedValue("");
          setSelectedValue2("");
      
}
  return (
    <form className={styles.msform}>
    <fieldset>
    <div className={styles.productFormContainer}>
      <h2 className={styles.label}>Product Upload Form</h2>
      <form >
        <label className={styles.label}>
          Product Name
          <input className={styles.input2}
            type="text"
            name="productName"
            value={productName}
            onChange={handleProductName}
            required
          />
        </label>

        <label className={styles.label}>
          Description
          <textarea className={styles.input2}
            name="description"
            value={Description}
            onChange={handleDescription}
            required
          />
        </label  >

        <label className={styles.labe3}>
          Price
          <input className={styles.input3}
            name="price"
            value={Price}
            onChange={handlePrice}
            required
            
          />
        </label>
        <label className={styles.labe3}>
          Brand name
          <input className={styles.input3}
            name="brandName"
            value={brandName}
            onChange={handleBrandName}
            required
            
          />
        </label>

        <label className={styles.labe3}>
          Image
          <input className={styles.input1}
            type="file"
            accept="image/*"
            onChange={handleFileChange}
            required
          />
        </label >

      <label className={styles.select1} htmlFor="mySelect">Select a Category:</label>
      <select className={styles.select_button}id="mySelect" value={selectedValue} onChange={handleSelectChange}>
        <option value="">Select</option>
        <option value="food">food</option>
        <option value="accessories">accessories</option>
        <option value="artiika">artiika</option>
        <option value="frontline">frontline</option>
        <option value="canin">canin</option>
        <option value="toys">toys</option>
        <option value="medicine">medicine</option>
      </select>
      <label className={styles.select2} htmlFor="mySelect">Select a Target animal:</label>
      <select className={styles.select_button}id="mySelect2" value={selectedValue2} onChange={handleSelectChange2}>
        <option value="">Select</option>
        <option value="dog">dog</option>
        <option value="cat">cat</option>
        <option value="bird">bird</option>
        <option value="pet">pet</option>
      </select>
      

        <button className={styles.button} type="submit" onClick={handleSubmit}>Upload Product</button>
      </form>
    </div>
    </fieldset>
    </form>
  );
};

export default ProductUploadForm;
