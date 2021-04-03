import React, { Component } from 'react';
import Modal from '../../Components/UI/Modal/Modal';
import Aux from '../Auxilliary/Auxilliary';

const withErrorHandler = (WrappedComponent, axios) => {
    return class extends Component {
        constructor(props) {
            super(props);
            this.state = {
                error: null
            };
            // axios.interceptors.request.use(req => {
            //     console.log("[ErrorHandler] Request: " + req.data);
            //     this.setState({error: null});
            //     return req;
            // })
            // axios.interceptors.response.use(res => res, error => {
            //     this.setState({error: error});
            //     console.log("[ErrorHandler] Error: " + error.message);
            //     console.log("[ErrorHandler] state", this.state);
            // });
        }

        componentWillMount() {
            this.reqInterceptor = axios.interceptors.request.use(req => {
                console.log("[ErrorHandler] Request: " + req.data);
                this.setState({error: null});
                return req;
            })
            this.resInterceptor = axios.interceptors.response.use(res => res, error => {
                this.setState({error: error});
                console.log("[ErrorHandler] Error: " + error.message);
                console.log("[ErrorHandler] state", this.state);
            });
        }

        componentWillUnmount() {
            axios.interceptors.request.eject(this.reqInterceptor);
            axios.interceptors.response.eject(this.resInterceptor);
        }

        clearError = () => {
            this.setState({error: null});
        }

        render() {
            // console.log('[ErrorHandler] render called');
        
            return (
                <Aux>
                    <Modal 
                        show={this.state.error}
                        modalClosed={this.clearError}
                    >
                        { this.state.error ? this.state.error.message : null }
                    </Modal>
                    <WrappedComponent {...this.props} />
                </Aux>
            );
        }
    }
};

export default withErrorHandler;