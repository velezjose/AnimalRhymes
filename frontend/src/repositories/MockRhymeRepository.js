export class MockRhymeRepository {
  getRhymes = async query => {
    return [
      "barked the dog",
      "blurbed the frog",
      "squealed the hog",
      "moaned the analog",
      "damn said the clam said the log",
    ];
  };
}
