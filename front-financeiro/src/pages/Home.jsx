import Header from "../components/Header/Header"
import ListDashboard from "../components/ListDashboard/ListDashboard"
import '../style/Home.css'

export default function Home () {
    
    return (
        <>
            <div className="main-home">
                <Header/>
                <ListDashboard/>
            </div>
        </>
    )
}