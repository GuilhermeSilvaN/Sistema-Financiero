import Header from "../components/Header/Header";
import ListEntradas from "../components/ListEntradas/ListEntradas";

export default function Entradas() {
    return (
        <>
            <div className="main-home">
                <Header/>
                <ListEntradas/>
            </div>
        </>
    )
}