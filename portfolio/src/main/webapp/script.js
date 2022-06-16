// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['I drink boba religiously.', 'My favorite season is spring.', 'I listen to r&b, rap, and pop music.', 'I am bilingual.'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

async function showServerSample() {
    //Send request to Sample Servlet
    const responseFromServer = await fetch('/sample');

    const obj = await responseFromServer.json();

    const randomObj = obj[Math.floor(Math.random() * obj.length)];
  
    const sampleContainer = document.getElementById('sample-container');
    sampleContainer.innerText = randomObj;
}

function loadSuggestions() {
    //Get JSON data 
    fetch('/list-form')
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            appendData(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

function appendData(data) {
    //Link to div element to display suggestions
    var suggestPage = document.getElementById("suggestions");

    //Parse JSON data and display as HTML
    for (var i = 0; i < data.length; i++) {
      var div = document.createElement("div");
      div.innerHTML = 'Suggestion: ' + data[i].value;
      suggestPage.appendChild(div);
    }
  }
