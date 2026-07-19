import Header from "../components/Header/Header";
import ListDespesa from "../components/ListDespesa/ListDespesa";

export default function Despesas() {
    return (
        <>
            <div className="main-home">
                <Header/>
                <ListDespesa/>
            </div>
        </>
    )
}