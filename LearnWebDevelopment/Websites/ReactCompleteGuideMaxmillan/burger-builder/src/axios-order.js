import axios from 'axios';

const instance = axios.create({
    baseURL: 'https://burger-builder-arkhera-default-rtdb.firebaseio.com/'
});

export default instance;