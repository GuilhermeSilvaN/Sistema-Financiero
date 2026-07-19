import api from './api';

const getPublicData = () => {
    return api.get("/login");
};

export default getPublicData;