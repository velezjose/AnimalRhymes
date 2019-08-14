import axios, { AxiosResponse } from 'axios';

const LOCAL_SAVAGE_RHYMES_URL = "http://localhost:8080/savageRhymes";

export class DevelopmentRhymeRepository {
  getRhymes = async (query: string) =>{ 
    const axiosResponse: AxiosResponse = await axios.get(LOCAL_SAVAGE_RHYMES_URL + `?q=${query}`);

    // TODO(ak): validate response or throw

    console.log(axiosResponse);
    console.log(axiosResponse.data);
    console.log(axiosResponse.data.results);
    return axiosResponse.data.results;
  }
}