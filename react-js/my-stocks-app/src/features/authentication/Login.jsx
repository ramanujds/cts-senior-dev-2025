import React from 'react'
import {useForm} from 'react-hook-form';
import {login} from "./authApi.js";
import {saveToken} from "./tokenManager.js";
import {useNavigate} from "react-router";

const Login = () => {

    const navigate = useNavigate();

    const {
        register,
        handleSubmit,
        reset,
        formState: {errors}
    }
        = useForm({
        defaultValues: {
            username: "",
            password: ""
        }
    });


    function onSubmit(data) {
        console.log(data);
        alert('Login successful');
        login(data.username,data.password).then(
            (response) => {
                saveToken(response.token)
                navigate("/")
            }
        )
            .catch(() => console.error("Login Unsuccessful"));
        reset();
    }


    return (
        <>
            <div className="flex items-center justify-center min-h-screen bg-gray-100">
                <div className="w-full max-w-md p-8 space-y-6 bg-white rounded shadow">
                    <h2 className="text-2xl font-bold text-center">Login</h2>
                    <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
                        <div>
                            <label className="block mb-1 font-medium">Username</label>
                            <input
                                type="text"
                                className='form-control'
                                {...register("username", {required: "Username is required"})}
                            />
                            {errors.username && <p className="text-red-500 text-sm mt-1">{errors.username.message}</p>}
                        </div>
                        <div>
                            <label className="block mb-1 font-medium">Password</label>
                            <input
                                type="password"
                                className='form-control'
                                {...register("password", {required: "Password is required"})}
                            />
                            {errors.password && <p className="text-red-500 text-sm mt-1">{errors.password.message}</p>}
                        </div>
                        <button
                            type="submit"
                            className="w-full px-4 py-2 font-bold text-white bg-blue-500 rounded hover:bg-blue-700"
                        >
                            Login
                        </button>
                    </form>
                </div>
            </div>
        </>
    )
}

export default Login