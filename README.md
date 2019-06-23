# AnimalRhymes

## Loose API Documentation
GET /api/v1/rhymes?q={query}
Get animals that rhyme with query.
Query can be arbitrarily long. Results should rhyme with the last one-two syllables.
Returns 
{
  "results": [
    ...
  ]
}