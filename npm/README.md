# Loan Calculator API

Loan Payment Calculator is a simple tool for calculating loan payments. It returns the monthly payment, total interest, and more.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)
[![npm version](https://img.shields.io/npm/v/@apiverve/loanpaymentcalculator.svg)](https://www.npmjs.com/package/@apiverve/loanpaymentcalculator)

This is a Javascript Wrapper for the [Loan Calculator API](https://apiverve.com/marketplace/loanpaymentcalculator?utm_source=npm&utm_medium=readme)

---

## Installation

Using npm:
```shell
npm install @apiverve/loanpaymentcalculator
```

Using yarn:
```shell
yarn add @apiverve/loanpaymentcalculator
```

---

## Configuration

Before using the Loan Calculator API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=npm&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=npm&utm_medium=readme)

The Loan Calculator API documentation is found here: [https://docs.apiverve.com/ref/loanpaymentcalculator](https://docs.apiverve.com/ref/loanpaymentcalculator?utm_source=npm&utm_medium=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const loanpaymentcalculatorAPI = require('@apiverve/loanpaymentcalculator');
const api = new loanpaymentcalculatorAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  "loanAmount": 32000,
  "interestRate": 8.5,
  "loanTerm": 6
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  "loanAmount": 32000,
  "interestRate": 8.5,
  "loanTerm": 6
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  "loanAmount": 32000,
  "interestRate": 8.5,
  "loanTerm": 6
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}
```

---

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "loanAmount": 32000,
    "downpayment": 0,
    "interestRate": 8.5,
    "loanTerm": 6,
    "monthly_payment": 568.91,
    "total_interest_paid": 8961.4,
    "total_payment": 40961.52,
    "interestRatio": 21.88,
    "formatted": {
      "loanAmount": "$32,000.00",
      "monthlyPayment": "$568.91",
      "totalInterestPaid": "$8,961.40",
      "totalPayment": "$40,961.52"
    },
    "amortization_schedule": [
      {
        "month": 1,
        "interest_payment": 226.67,
        "principal_payment": 342.24,
        "remaining_balance": 31657.76
      },
      {
        "month": 2,
        "interest_payment": 224.24,
        "principal_payment": 344.67,
        "remaining_balance": 31313.09
      },
      {
        "month": 3,
        "interest_payment": 221.8,
        "principal_payment": 347.11,
        "remaining_balance": 30965.99
      }
    ]
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=npm&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=npm&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=npm&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=npm&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
