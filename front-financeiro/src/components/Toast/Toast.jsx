import { useEffect } from "react";
import "./Toast.css";
export default function Toast({ 
    message, 
    type = "error", 
    onClose 
}) {
    useEffect(()=> {
        const timer = setTimeout(()=>{
            onClose();

        }, 4000);

        return ()=> clearTimeout(timer);
    }, [onClose]);

    return (
        <div className={`toast ${type}`}>
            <div className="toast-content">
                <span className="toast-icon">
                    {type === "error" ? "✕" : "✓"}
                </span>
                <p>
                    {message}
                </p>
            </div>
            <div className="toast-progress"></div>
        </div>

    );

}