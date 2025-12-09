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
        /// The loan amount (e.g., 20000)
        /// Example: 20000
        /// </summary>
        [JsonProperty("loanAmount")]
        public string LoanAmount { get; set; }

        /// <summary>
        /// The interest rate (e.g., 5.5)
        /// Example: 5.5
        /// </summary>
        [JsonProperty("interestRate")]
        public string InterestRate { get; set; }

        /// <summary>
        /// The loan term in years (e.g 6)
        /// Example: 5
        /// </summary>
        [JsonProperty("loanTerm")]
        public string LoanTerm { get; set; }
    }
}
