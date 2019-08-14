import axios, { AxiosResponse } from 'axios';

const LOCAL_SAVAGE_RHYMES_URL = 'http://localhost:8080/savageRhymes';

export class DevelopmentRhymeRepository {
  getRhymes = async (query: string) => {
    const axiosResponse: AxiosResponse = await axios.get(
      LOCAL_SAVAGE_RHYMES_URL + `?q=${query}`
    );
    if (
      !axiosResponse ||
      !axiosResponse.data ||
      !Array.isArray(axiosResponse.data.results)
    ) {
      throw new Error(
        `SavageRhymes response didn't include a results array: ${axiosResponse}.`
      );
    }
    return axiosResponse.data.results;
  };
}
