const { MongoClient } = require('mongodb');

// Connection URL
const url = 'mongodb://root:rootpwd@localhost:27017';
const client = new MongoClient(url);

// Database Name
const dbName = 'ufcweb2022';

var user_collection;
async function main() {
  // Use connect method to connect to the server
  await client.connect();
  console.log('Connected successfully to Mongo server');
  const db = client.db(dbName);
  user_collection = db.collection('user');
  // the following code examples can be pasted here...
   
  return 'done.';
}

main()
  .then(console.log)
  .catch(console.error);
//   .finally(() => client.close());

async function getUsers(username, password) {
    const findResult = await user_collection.find({username: username, password: password}).toArray();
    console.log('Found documents =>', findResult);
    return findResult;
}

exports.getUsers = getUsers;
