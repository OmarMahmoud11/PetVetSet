import dog from "../images/Sign-In-1.jpg"
import { FaHome } from "react-icons/fa";
import styles from '../CSS/style.module.css'
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { FaGoogle } from "react-icons/fa";
import { Link } from "react-router-dom";


export default function Signup() {

    const navigate = useNavigate();
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const [confirmedPassword, setConfirmedPassword] = useState("");
    const [email, setEmail] = useState("");
    const handleUserName = (e) => {
        setUserName(e.target.value);
        console.log(userName);
    }
    const handlePassword = (e) => {
        setPassword(e.target.value);
        console.log(password);
    }
    const handleConfirmedPassword = (e) => {
        setConfirmedPassword(e.target.value);
        console.log(confirmedPassword);
    }
    const handleEmail = (e) => {
        setEmail(e.target.value);
        console.log(email);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(userName);
        console.log(password);
        console.log(email);
        navigate('/', { replace: true, state: { userName, password, email } });
    }
    return (
        <>
            <div className={styles.signin}>
                <div className={styles.content}>
                    <form onSubmit={handleSubmit}>
                        <Link to="/Signin" className={styles.home}><FaHome></FaHome> Return</Link>
                        <div className={styles.headup}>Sign up</div>
                        <input type="text" placeholder="Username" value={userName} onChange={handleUserName} required></input>
                        <input type="password" placeholder="Password" value={password} onChange={handlePassword} pattern="(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required></input>
                        <input type="password" placeholder="Confirm Password" value={confirmedPassword} onChange={handleConfirmedPassword} pattern={password} title="Password and Confirm Password does not match." required></input>
                        <input type="email" placeholder="Email" value={email} onChange={handleEmail}></input>
                        <button type="submit">Sign Up</button>
                        <div className={styles.line}>or sign up with</div>
                        <div className={styles.googleSign}><FaGoogle></FaGoogle> Google</div> {/*Need to implement in google OAuth*/}
                    </form>
                    <img src={dog}></img>
                </div>
            </div>
        </>
    )
}