declare module '@apiverve/loanpaymentcalculator' {
  export interface loanpaymentcalculatorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface loanpaymentcalculatorResponse {
    status: string;
    error: string | null;
    data: any;
    code?: number;
  }

  export default class loanpaymentcalculatorWrapper {
    constructor(options: loanpaymentcalculatorOptions);

    execute(callback: (error: any, data: loanpaymentcalculatorResponse | null) => void): Promise<loanpaymentcalculatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: loanpaymentcalculatorResponse | null) => void): Promise<loanpaymentcalculatorResponse>;
    execute(query?: Record<string, any>): Promise<loanpaymentcalculatorResponse>;
  }
}
