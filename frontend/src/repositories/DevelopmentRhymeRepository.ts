import axios, { AxiosResponse } from 'axios';

const SAVAGE_RHYMES_URL = 'https://animal-rhymes-frontend.herokuapp.com/savageRhymes';

export class DevelopmentRhymeRepository {
  getRhymes = async (query: string) => {
    const axiosResponse: AxiosResponse = await axios.get(
      SAVAGE_RHYMES_URL + `?q=${query}`
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
