using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.LoanCalculator
{
    /// <summary>
    /// Query options for the Loan Calculator API
    /// </summary>
    public class LoanCalculatorQueryOptions
    {
        /// <summary>
        /// The loan amount
        /// </summary>
        [JsonProperty("loanAmount")]
        public string LoanAmount { get; set; }

        /// <summary>
        /// The interest rate (percentage)
        /// </summary>
        [JsonProperty("interestRate")]
        public string InterestRate { get; set; }

        /// <summary>
        /// The loan term in years
        /// </summary>
        [JsonProperty("loanTerm")]
        public string LoanTerm { get; set; }
    }
}
