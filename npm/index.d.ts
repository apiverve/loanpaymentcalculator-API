declare module '@apiverve/loanpaymentcalculator' {
  export interface loanpaymentcalculatorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface loanpaymentcalculatorResponse {
    status: string;
    error: string | null;
    data: LoanCalculatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface LoanCalculatorData {
      loanAmount:           number | null;
      downpayment:          number | null;
      interestRate:         number | null;
      loanTerm:             number | null;
      monthlyPayment:       number | null;
      totalInterestPaid:    number | null;
      totalPayment:         number | null;
      interestRatio:        number | null;
      formatted:            Formatted;
      amortizationSchedule: AmortizationSchedule[];
  }
  
  interface AmortizationSchedule {
      month:            number | null;
      interestPayment:  number | null;
      principalPayment: number | null;
      remainingBalance: number | null;
  }
  
  interface Formatted {
      loanAmount:        null | string;
      monthlyPayment:    null | string;
      totalInterestPaid: null | string;
      totalPayment:      null | string;
  }

  export default class loanpaymentcalculatorWrapper {
    constructor(options: loanpaymentcalculatorOptions);

    execute(callback: (error: any, data: loanpaymentcalculatorResponse | null) => void): Promise<loanpaymentcalculatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: loanpaymentcalculatorResponse | null) => void): Promise<loanpaymentcalculatorResponse>;
    execute(query?: Record<string, any>): Promise<loanpaymentcalculatorResponse>;
  }
}
